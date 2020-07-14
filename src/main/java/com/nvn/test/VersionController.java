package com.nvn.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
	
    @Autowired
    private YAMLConfig myConfig;

	@RequestMapping("/version")
	public Version index() {
		Version version = new Version();
		HashMap<String,String> myapplication = new HashMap<String,String>();
		myapplication.put("version", myConfig.getVersion());
		myapplication.put("lastcommitsha", readGitProperties());
		myapplication.put("description", "pre-interview technical test");
		version.setMyapplicaiton(myapplication);
		return version;
	}

	private String readGitProperties() {
	    ClassLoader classLoader = getClass().getClassLoader();
	    InputStream inputStream = classLoader.getResourceAsStream("git.properties");
	    try {
	        return readFromInputStream(inputStream) + myConfig.getVersion();
	    } catch (IOException e) {
	        return "Git version not retrieved";
	    }
	}
	private String readFromInputStream(InputStream inputStream)
	throws IOException {
	    String resultString = "";
	    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	        	if (line.contains("git.commit.id=")) {
	        		resultString = line.split("=")[1];
	        	}
	        }
	    }
	    return resultString.toString();
	}
}
