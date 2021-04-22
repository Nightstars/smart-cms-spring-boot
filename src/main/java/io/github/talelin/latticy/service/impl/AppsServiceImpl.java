package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.apps.CreateOrUpdateAppsDTO;
import io.github.talelin.latticy.mapper.AppsMapper;
import io.github.talelin.latticy.model.AppsDO;
import io.github.talelin.latticy.service.AppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppsServiceImpl implements AppsService {
    @Autowired
    private AppsMapper appsMapper;

    @Override
    public List<AppsDO> getAll() {
        return appsMapper.selectList(null);
    }

    @Override
    public boolean createApp(CreateOrUpdateAppsDTO validator) {
        AppsDO appsDO=new AppsDO();
        appsDO.setName(validator.getName());
        appsDO.setUrl(validator.getUrl());
        appsDO.setIcon(validator.getIcon());
        appsDO.setSummary(validator.getSummary());
        return appsMapper.insert(appsDO)>0;
    }
}
