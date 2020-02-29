package com.biblioteket.webservice.fil.controller;

import com.biblioteket.webservice.fil.exception.ListaFilerMisslyckadesException;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FilControllerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(FileNotFoundException.class)
  public void hanteraFilKundeIntehittas(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.NOT_FOUND.value());
  }

  @ExceptionHandler(ListaFilerMisslyckadesException.class)
  public void hanteraListaFilerMisslyckades(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
  }


}
