package io.choerodon.agile.app.service;

import io.choerodon.agile.api.dto.CumulativeFlowDiagramDTO;
import io.choerodon.agile.api.dto.CumulativeFlowFilterDTO;
import io.choerodon.agile.api.dto.ReportIssueDTO;

import java.util.List;

/**
 * @author dinghuang123@gmail.com
 * @since 2018/6/19
 */
public interface ReportService {

    /**
     * 燃尽图报告信息
     *
     * @param projectId projectId
     * @param sprintId  sprintId
     * @param type      storyPoints、remainingEstimatedTime、originalEstimatedTime、issueCount
     * @return ReportIssueDTO
     */
    List<ReportIssueDTO> queryBurnDownReport(Long projectId, Long sprintId, String type);

    /**
     * 查看累积流量图
     *
     * @param projectId               projectId
     * @param cumulativeFlowFilterDTO cumulativeFlowFilterDTO
     * @return CumulativeFlowDiagramDTO
     */
   CumulativeFlowDiagramDTO queryCumulativeFlowDiagram(Long projectId, CumulativeFlowFilterDTO cumulativeFlowFilterDTO);
}
