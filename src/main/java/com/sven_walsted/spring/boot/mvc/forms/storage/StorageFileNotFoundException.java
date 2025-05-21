package com.sven_walsted.spring.boot.mvc.forms.storage;

/**
 * @author https://spring.io/guides/gs/uploading-files
 */
public class StorageFileNotFoundException extends StorageException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public StorageFileNotFoundException(String message) {
    super(message);
  }

  public StorageFileNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
