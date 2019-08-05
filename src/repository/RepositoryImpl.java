package repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RepositoryImpl implements Repository {
    private LinkedHashMap<Integer, ArrayList<String>> repository;

    public RepositoryImpl() {
        this.repository = new LinkedHashMap<>();
    }

    public LinkedHashMap<Integer, ArrayList<String>> getRepository() {
        return this.repository;
    }

}
