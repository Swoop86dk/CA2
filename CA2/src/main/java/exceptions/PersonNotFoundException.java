package exceptions;

import com.sun.jersey.api.Responses;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


public class PersonNotFoundException extends WebApplicationException {

    /**
     * Creates a new instance of <code>PersonNotFoundException</code> without
     * detail message.
     */
    public PersonNotFoundException() {
        super(Responses.notFound().build());
    }

    /**
     * Constructs an instance of <code>PersonNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PersonNotFoundException(String message) {
        super(Response.status(Responses.NOT_FOUND).
            entity(message).type("text/plain").build());
        
    }
}
