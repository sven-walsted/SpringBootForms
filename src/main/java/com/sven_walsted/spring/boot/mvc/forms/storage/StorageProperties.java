package com.sven_walsted.spring.boot.mvc.forms.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author https://spring.io/guides/gs/uploading-files
 */
@ConfigurationProperties("storage")
public class StorageProperties {

  /**
   * Folder location for storing files
   */
  private String location = "upload-dir";

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

}
