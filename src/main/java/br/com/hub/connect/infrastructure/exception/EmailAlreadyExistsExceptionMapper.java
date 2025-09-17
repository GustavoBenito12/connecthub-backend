package br.com.hub.connect.infrastructure.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.hub.connect.domain.exception.EmailAlreadyExistsException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class EmailAlreadyExistsExceptionMapper implements ExceptionMapper<EmailAlreadyExistsException> {
  private static final Logger logger = LoggerFactory.getLogger(EmailAlreadyExistsExceptionMapper.class);

  @Override
  public Response toResponse(EmailAlreadyExistsException exception) {
    logger.warn("Email already exists: {}", exception.getMessage());

    ErrorResponse error = new ErrorResponse(
        "EMAIL_ALREADY_EXISTS",
        exception.getMessage(),
        409);

    return Response.status(409).entity(error).build();
  }
}
