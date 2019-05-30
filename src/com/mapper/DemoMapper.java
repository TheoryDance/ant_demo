package com.mapper;

import java.util.List;
import java.util.Map;

public interface DemoMapper {

	List<Map<String, Object>> getLastItems(int i);

	int addItem(String content);

}
