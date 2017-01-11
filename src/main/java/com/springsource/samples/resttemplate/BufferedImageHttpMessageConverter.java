/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.springsource.samples.resttemplate;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class BufferedImageHttpMessageConverter implements HttpMessageConverter<BufferedImage> {

    public List<MediaType> getSupportedMediaTypes() {
        return Collections.singletonList(new MediaType("image", "jpeg"));
    }

    public boolean supports(Class<? extends BufferedImage> clazz) {
        return BufferedImage.class.equals(clazz);
    }


    public void write(BufferedImage image, HttpOutputMessage message) throws IOException {
        throw new UnsupportedOperationException("Not implemented");
    }

	@Override
	public boolean canRead(Class<?> arg0, MediaType arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canWrite(Class<?> arg0, MediaType arg1) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void write(BufferedImage arg0, MediaType arg1, HttpOutputMessage arg2) throws IOException,
		HttpMessageNotWritableException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BufferedImage read(Class<? extends BufferedImage> arg0, HttpInputMessage inputMessage) throws IOException,
		HttpMessageNotReadableException {
		return ImageIO.read(inputMessage.getBody());
	}

}
