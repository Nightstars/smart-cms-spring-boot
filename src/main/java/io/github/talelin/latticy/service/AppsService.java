package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.apps.CreateOrUpdateAppsDTO;
import io.github.talelin.latticy.model.AppsDO;
import java.util.List;

public interface AppsService {

    List<AppsDO> getAll();

    boolean createApp(CreateOrUpdateAppsDTO validator);

    AppsDO getById(Long id);

    boolean deleteById(Long id);

    boolean updateById(AppsDO appsDO,CreateOrUpdateAppsDTO createOrUpdateAppsDTO);
}
