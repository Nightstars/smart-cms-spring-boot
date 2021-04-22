package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.apps.CreateOrUpdateAppsDTO;
import io.github.talelin.latticy.model.AppsDO;
import java.util.List;

public interface AppsService {

    List<AppsDO> getAll();

    boolean createApp(CreateOrUpdateAppsDTO validator);

}
