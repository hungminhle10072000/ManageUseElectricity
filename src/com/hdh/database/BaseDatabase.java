package com.hdh.database;

import com.hdh.model.BaseModel;

import java.util.HashMap;
import java.util.Map;

public class BaseDatabase {

    private Map<Integer, BaseModel> maps = new HashMap<Integer, BaseModel>();

    public BaseModel create(BaseModel t){
            t.setId(maps.size()+1);
            maps.put(maps.size()+1, t);
            return t;
    }

    public BaseModel findById(int id){
            return maps.get(id);
    }

    public void deleteById(int id){
        maps.remove(id);
    }

    public Map<Integer, BaseModel> getAll() {
        return maps;
    }

    public Map<Integer, BaseModel> getMaps() {
        return maps;
    }

    public void setMaps(Map<Integer, BaseModel> maps) {
        this.maps = maps;
    }


}
