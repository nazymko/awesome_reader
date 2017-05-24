package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nazymko on 24.05.2017.
 */
public class RawReader {

    public static void main(String[] args) throws IOException {
        String s = null;
        for (Sources sources : Sources.values()) {
            s = new RawReader().readRaw(sources);

            File file = new File(sources.getName() + ".json");
            file.createNewFile();

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(s);
            fileWriter.flush();
        }
    }

    private String readRaw(Sources sources) throws IOException {
        System.out.println("reading = " + sources.getName());
        return readRaw(sources.getUrl(), sources.getName(), sources.getChapter());
    }

    public String readRaw(String path, String name, String chapter) throws IOException {
        ArrayList<String> strings = readFromNet(path);

        HashMap<String, List<Group>> container = new HashMap<>();
        ArrayList<Group> list = new ArrayList<>();
        container.put(name, list);

        Group lastGroup = null;

        for (String line : strings) {

            Group group = isGroup(line, lastGroup, chapter);
            if (group != null) {
                lastGroup = group;
                list.add(lastGroup);
            }


            if (lastGroup != null) {
                Tool tool = isTool(line.trim());

                if (tool != null) {
                    lastGroup.add(tool);
                }

            }


        }
        System.out.println("size: " + list.size());
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(container);
    }

    private Pattern pattern = Pattern.compile("\\S?\\s*\\[(?<name>.*)\\]\\((?<url>\\S*)\\)\\s*\\-?(?<description>.*)");

    private Tool isTool(String line) {

        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {

            String name = matcher.group("name");
            String url = matcher.group("url");
            String description = matcher.group("description");


            if (name.contains("http://") || name.contains("https://")) {
                return null;
            }

            return new Tool(name, url, description);
        }


        return null;
    }

    private Group isGroup(String line, Group lastGroup, String chapter) {
        return line.trim().startsWith(chapter) ? new Group(groupFromLine(line,chapter), new ArrayList<Tool>()) : null;
    }

    private String groupFromLine(String line, String chapter) {
        if (line.trim().startsWith(chapter)) {
            return line.trim().substring(3).trim();
        }
        return line;
    }

    private ArrayList<String> readFromNet(String path) {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new URL(path).openStream()))) {
            String line = null;
            ArrayList<String> strings = new ArrayList<>();
            while ((line = in.readLine()) != null) {
                strings.add(line);
            }
            return strings;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static class Group {
        private String group;

        public String getName() {
            return group;
        }

        public void setName(String name) {
            this.group = name;
        }

        public List<Tool> getTools() {
            return tools;
        }

        public void setTools(List<Tool> tools) {
            this.tools = tools;
        }

        public Group(String group, List<Tool> tools) {

            this.group = group;
            this.tools = tools;
        }

        public void add(Tool tool) {
            tools.add(tool);
        }

        private List<Tool> tools;
    }

    static class Tool {
        private String name;
        private String path;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Tool(String name, String path, String description) {

            this.name = trim(name);
            this.path = trim(path);
            this.description = trim(description);
        }

        private String trim(String name) {
            if (name == null) {
                return name;
            } else {
                return name.trim();
            }
        }

        String description;
    }


}
