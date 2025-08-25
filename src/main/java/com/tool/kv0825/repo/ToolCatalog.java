
package com.tool.kv0825.repo;

import com.tool.kv0825.model.Tool;
import com.tool.kv0825.model.ToolType;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ToolCatalog {
    private final Map<String, Tool> tools = new LinkedHashMap<>();

    public ToolCatalog() {
        tools.put("CHNS", new Tool("CHNS", ToolType.CHAINSAW, "Stihl"));
        tools.put("LADW", new Tool("LADW", ToolType.LADDER, "Werner"));
        tools.put("JAKD", new Tool("JAKD", ToolType.JACKHAMMER, "DeWalt"));
        tools.put("JAKR", new Tool("JAKR", ToolType.JACKHAMMER, "Ridgid"));
    }

    public Collection<Tool> findAll() { return tools.values(); }
    public Optional<Tool> findByCode(String code) { return Optional.ofNullable(tools.get(code)); }
    public Tool getByCode(String code) {
        return findByCode(code).orElseThrow(() -> new IllegalArgumentException("Unknown tool code: " + code));
    }
    public Tool save(Tool tool) {
        tools.put(tool.getCode(), tool);
        return tool;
    }
    public void delete(String code) { tools.remove(code); }
}
