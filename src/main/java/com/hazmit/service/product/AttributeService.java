package com.hazmit.service.product;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface AttributeService {
	Slice<AttributeResponse> listAllByPage(Pageable pageable);
}
