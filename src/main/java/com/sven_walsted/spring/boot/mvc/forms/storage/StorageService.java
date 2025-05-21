package com.sven_walsted.spring.boot.mvc.forms.storage;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author https://spring.io/guides/gs/uploading-files
 */
public interface StorageService {
  void init();

  void store(MultipartFile file);

  Stream<Path> loadAll();

  Path load(String filename);

  Resource loadAsResource(String filename);

  void deleteAll();
}
