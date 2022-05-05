package co.com.nttdata.platform.modules.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.nttdata.platform.crosscutting.domain.UserDto;
import co.com.nttdata.platform.crosscutting.payload.GetUserPayload;
import co.com.nttdata.platform.modules.common.ApiResponse;
import co.com.nttdata.platform.modules.common.EbusinessConstant;
import co.com.nttdata.platform.modules.usecase.service.ProcessUser;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = EbusinessConstant.USER_API, produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserApi {

	@Autowired
	private ProcessUser processUser;
	
	@ApiOperation(value = "Obtain user ", notes = "It allows obtaining user,  type of document that is a numerical data 1 (cedula), 2 (passport)")
	@GetMapping()
	public ResponseEntity<ApiResponse<UserDto>> getUsers(@Valid GetUserPayload payload) {
		return new ResponseEntity<>(processUser.getUser(payload),HttpStatus.OK);
	}
}
