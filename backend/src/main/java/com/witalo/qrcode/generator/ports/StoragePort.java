package com.witalo.qrcode.generator.ports;

import org.springframework.context.annotation.Bean;


public interface StoragePort {

    String uploadFile(byte[] fileData, String fileName, String contentType);
}
