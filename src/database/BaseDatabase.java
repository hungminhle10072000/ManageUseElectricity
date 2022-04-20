package database;

import com.hdh.model.BaseModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDatabase <T extends BaseModel>{
    private Map<Integer, T> maps = new HashMap<Integer, T>();

    public T create(T t){
            t.setId(maps.size()+1);
            maps.put(maps.size(), t);
            return t;
    }

    public T findById(int id){
            return maps.get(id);
    }

    public Map<Integer, T> getAll() {
        return maps;
    }

}
