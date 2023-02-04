package rafael.ejercicio.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import rafael.ejercicio.Exeptions.ErrorResponse;
import rafael.ejercicio.Exeptions.ResourceNotFoundException;

@RestControllerAdvice
public class ErrorHandlerController  {

    @ExceptionHandler(value={ResourceNotFoundException.class})
public ResponseEntity<ErrorResponse> HandResourceNotFoundException(RuntimeException e, WebRequest request){
   ErrorResponse errorResponse=new ErrorResponse();
   errorResponse.setStatus(HttpStatus.NOT_FOUND);
   errorResponse.setMessage(e.getMessage());
   errorResponse.setCode(404);
   errorResponse.setBackendMessage("The resource can not  be found in the data Base");
   return new ResponseEntity(errorResponse,HttpStatus.OK);
}

   @ExceptionHandler(value={Exception.class})
   public ResponseEntity<ErrorResponse> HandFatalException(RuntimeException e, WebRequest request){
      ErrorResponse errorResponse=new ErrorResponse();
      errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
      errorResponse.setMessage(e.getMessage());
      errorResponse.setCode(500);
      errorResponse.setBackendMessage("Internal server error");
      return new ResponseEntity(errorResponse,HttpStatus.OK);
   }


}
