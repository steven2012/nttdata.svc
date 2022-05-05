package co.com.nttdata.platform.modules.dataproviders.jpa;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.nttdata.platform.crosscutting.domain.UserDto;
import co.com.nttdata.platform.crosscutting.domain.UserDtoMapping;
import co.com.nttdata.platform.crosscutting.payload.GetUserPayload;
import co.com.nttdata.platform.modules.common.ApiResponse;
import co.com.nttdata.platform.modules.common.EbusinessConstant;
import co.com.nttdata.platform.modules.common.MessageConstant;
import co.com.nttdata.platform.modules.common.MessagesUtil;
import co.com.nttdata.platform.modules.dataproviders.UserDataProvider;

@Component
public class JpaUserDataProvider implements UserDataProvider {

	@Autowired
	private MessagesUtil messagesUtil;

	@Override
	public ApiResponse<UserDto> getUser(GetUserPayload payload) {

		ApiResponse<UserDto> response = new ApiResponse<>();

		try {
			ObjectMapper mapper = new ObjectMapper();
			
			ClassPathResource resource = new ClassPathResource(EbusinessConstant.PATH_MOCK);
			InputStream inputStream = resource.getInputStream();
			List<UserDtoMapping> dto = mapper.readValue(inputStream, new TypeReference<List<UserDtoMapping>>() {
			});

			if (dto == null) {
				response.setData(null);
				response.setMessage(messagesUtil.getMessage(MessageConstant.ERROR_MAPPING));
				response.setStatusCode(HttpStatus.BAD_REQUEST.value());
				response.setSuccess(false);
				return response;
			}

			// Filter User by TypeId and numberId
			Optional<UserDtoMapping> userFilter = dto.stream().filter(x -> x.getTypeDocument() == EbusinessConstant.TYPE_DOCUMENT_CC
					&& x.getIdDocument().equals(payload.getIdDocument()))
			.findFirst();
			
			if(!userFilter.isPresent()) {
				response.setData(null);
				response.setMessage(messagesUtil.getMessage(MessageConstant.USER_NOT_FOUND));
				response.setStatusCode(HttpStatus.NOT_FOUND.value());
				response.setSuccess(false);
				return response;		
			}
			
			UserDtoMapping userFilterValue=userFilter.get();

			UserDto dtoResponse= new UserDto();
			dtoResponse.setFirtsName(userFilterValue.getFirtsName());
			dtoResponse.setLastName(userFilterValue.getLastName());
			dtoResponse.setSecondLastName(userFilterValue.getSecondLastName());
			dtoResponse.setSecondName(userFilterValue.getSecondName());
			
			response.setData(dtoResponse);
			response.setMessage("");
			response.setStatusCode(HttpStatus.OK.value());
			response.setSuccess(true);
			
			return response;

		} catch (Exception ex) {

			response.setData(null);
			response.setMessage(ex.getMessage());
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setSuccess(false);
			return response;
		}
	}

}
