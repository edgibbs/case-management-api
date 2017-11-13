package gov.ca.cwds.cm.service;

import com.google.inject.Inject;
import gov.ca.cwds.cm.service.mapper.CaseMapper;
import gov.ca.cwds.data.legacy.cms.dao.CaseDao;
import gov.ca.cwds.data.legacy.cms.entity.Case;
import gov.ca.cwds.rest.api.Response;

import java.io.Serializable;

public class CaseService extends CrudServiceAdapter {

	private CaseDao caseDao;
	private CaseMapper caseMapper;

	@Inject
	public CaseService(CaseDao caseDao, CaseMapper caseMapper) {
		this.caseDao = caseDao;
		this.caseMapper = caseMapper;
	}

	@Override
	public Response find(Serializable param) {
		Case caseEntity = caseDao.find(param);
		return caseMapper.toCaseDTO(caseEntity);
	}
}
