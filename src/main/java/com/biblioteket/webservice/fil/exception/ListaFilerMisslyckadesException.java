package com.biblioteket.webservice.fil.exception;

import java.io.IOException;

public class ListaFilerMisslyckadesException extends IOException {

  public ListaFilerMisslyckadesException(String meddelande, IOException e) {
    super(meddelande, e);
  }
}
