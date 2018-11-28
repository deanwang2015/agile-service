package io.choerodon.agile.domain.agile.event;

import io.choerodon.agile.api.dto.StatusMapDTO;

import java.util.List;

/**
 * @author shinan.chen
 * @date 2018/11/23
 */
public class StateMachineSchemeDeployUpdateIssue {
    private List<StateMachineSchemeChangeItem> changeItems;
    private List<ProjectConfig> projectConfigs;
    private List<StatusMapDTO> addStatuses;
    private List<StatusMapDTO> deleteStatuses;

    public List<ProjectConfig> getProjectConfigs() {
        return projectConfigs;
    }

    public void setProjectConfigs(List<ProjectConfig> projectConfigs) {
        this.projectConfigs = projectConfigs;
    }

    public List<StateMachineSchemeChangeItem> getChangeItems() {
        return changeItems;
    }

    public void setChangeItems(List<StateMachineSchemeChangeItem> changeItems) {
        this.changeItems = changeItems;
    }

    public List<StatusMapDTO> getAddStatuses() {
        return addStatuses;
    }

    public void setAddStatuses(List<StatusMapDTO> addStatuses) {
        this.addStatuses = addStatuses;
    }

    public List<StatusMapDTO> getDeleteStatuses() {
        return deleteStatuses;
    }

    public void setDeleteStatuses(List<StatusMapDTO> deleteStatuses) {
        this.deleteStatuses = deleteStatuses;
    }
}