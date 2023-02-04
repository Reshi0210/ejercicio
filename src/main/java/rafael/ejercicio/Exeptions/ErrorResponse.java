package rafael.ejercicio.Exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class ErrorResponse {

    private HttpStatus status;
    private String message;
    private Integer code;
    private String backendMessage;
}
