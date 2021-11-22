package com.RezaRahadiJmartMH;


import com.RezaRahadiJmartMH.dbjson.JsonTable;
import com.RezaRahadiJmartMH.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;
import com.RezaRahadiJmartMH.Algorithm;

import java.util.List;

@RestController
public interface BasicGetController<T extends Serializable> {
    @GetMapping("/page")
    public @ResponseBody List<T> getPage(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="5") int pageSize);
    @GetMapping("/{id}")
    public T getById(@PathVariable int id);

    public abstract JsonTable<T> getJsonTable();
}

