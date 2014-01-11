package com.jamesac.NaughtyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NameList {

	private Path path;
	BufferedReader reader;

	public List<Student> students = new ArrayList<Student>();

	public NameList() {

	}

	public NameList(Path path) {
		LoadList(path);
		this.path = path;
	}

	public void LoadList(Path path) {
		List<String> names = null;
		try {
			names = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Error reading class file");
			e.printStackTrace();
		}
		for (String string : names) {
			students.add(new Student(string));
		}
	}
	
	public void UpdateList() {
		LoadList(path);
	}
	
}
