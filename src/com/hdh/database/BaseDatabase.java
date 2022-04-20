package com.hdh.database;

import com.hdh.model.BaseModel;

import java.util.HashMap;
import java.util.Map;

public class BaseDatabase <T extends BaseModel>{

    private Map<Integer, T> maps = new HashMap<Integer, T>();

    public T create(T t){
            t.setId(maps.size()+1);
            maps.put(maps.size()+1, t);
            return t;
    }

    public T findById(int id){
            return maps.get(id);
    }

    public void deleteById(int id){
        maps.remove(id);
    }

    public Map<Integer, T> getAll() {
        return maps;
    }

    public Map<Integer, T> getMaps() {
        return maps;
    }

    public void setMaps(Map<Integer, T> maps) {
        this.maps = maps;
    }
}
