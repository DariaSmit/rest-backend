package guruqa.restbackend.controller.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED )
public class InvalidUserNameException extends Error {
}
