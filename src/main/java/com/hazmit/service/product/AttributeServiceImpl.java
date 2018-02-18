package com.hazmit.service.product;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AttributeServiceImpl implements AttributeService {

	@Autowired
	AttributeRepository attributeRepository;

	@Autowired
	AttributeValueRepository attributeValueRepository;

	public Function<Attribute, AttributeResponse> getAttributeToReponseConverter(
			final Set<AttributeValueResponse> attributeValue) {
		return new Function<Attribute, AttributeResponse>() {
			@Override
			public AttributeResponse apply(Attribute source) {
				AttributeResponse attributeResponse = new AttributeResponse(source, attributeValue);
				return attributeResponse;
			}
		};
	}

	@Override
	public Slice<AttributeResponse> listAllByPage(Pageable pageable) {
		Set<AttributeValueResponse> attributeValues=new HashSet<AttributeValueResponse>();
		attributeValueRepository.findAll().forEach((attributeValue) -> attributeValues.add(new AttributeValueResponse(attributeValue)));
		Slice<AttributeResponse> result = attributeRepository.findAll(pageable).map(getAttributeToReponseConverter(attributeValues));
		return result;
	}

}
