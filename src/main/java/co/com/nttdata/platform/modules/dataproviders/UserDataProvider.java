package co.com.nttdata.platform.modules.dataproviders;

import co.com.nttdata.platform.crosscutting.domain.UserDto;
import co.com.nttdata.platform.crosscutting.payload.GetUserPayload;
import co.com.nttdata.platform.modules.common.ApiResponse;

public interface UserDataProvider {

	public ApiResponse<UserDto>getUser(GetUserPayload payload);

}
