package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse65.AAD_Course_Work.reqAndresp.secure.SignIn;
import lk.ijse.gdse65.AAD_Course_Work.reqAndresp.secure.SignUp;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);
    JwtAuthResponse refreshToken(String accessToken);

}
