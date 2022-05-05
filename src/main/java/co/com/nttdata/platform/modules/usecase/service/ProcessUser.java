package co.com.nttdata.platform.modules.usecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.nttdata.platform.crosscutting.domain.UserDto;
import co.com.nttdata.platform.crosscutting.payload.GetUserPayload;
import co.com.nttdata.platform.modules.common.ApiResponse;
import co.com.nttdata.platform.modules.dataproviders.UserDataProvider;

@Service
public class ProcessUser {

	@Autowired
	private UserDataProvider dataProvider;
	
	public ApiResponse<UserDto> getUser(GetUserPayload payload) {
		return dataProvider.getUser(payload);
	}	

}
