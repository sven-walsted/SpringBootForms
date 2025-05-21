package com.sven_walsted.spring.boot.mvc.forms.storage;

/**
 * @author https://spring.io/guides/gs/uploading-files
 */
public class StorageException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public StorageException(String message) {
    super(message);
  }

  public StorageException(String message, Throwable cause) {
    super(message, cause);
  }
}
