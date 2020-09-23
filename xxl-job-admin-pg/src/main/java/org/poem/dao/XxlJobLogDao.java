package org.poem.dao;

import org.poem.core.model.XxlJobLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * job log
 *
 * @author xuxueli 2016-1-12 18:03:06
 */
@Mapper
public interface XxlJobLogDao {

    // exist jobId not use jobGroup, not exist use jobGroup
    public List<XxlJobLog> pageList(@Param("offset") int offset,
                                    @Param("pagesize") int pagesize,
                                    @Param("jobGroup") Long jobGroup,
                                    @Param("jobId") Long jobId,
                                    @Param("triggerTimeStart") Date triggerTimeStart,
                                    @Param("triggerTimeEnd") Date triggerTimeEnd,
                                    @Param("logStatus") int logStatus);

    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize,
                             @Param("jobGroup") Long jobGroup,
                             @Param("jobId") Long jobId,
                             @Param("triggerTimeStart") Date triggerTimeStart,
                             @Param("triggerTimeEnd") Date triggerTimeEnd,
                             @Param("logStatus") int logStatus);

    public XxlJobLog load(@Param("id") Long id);

    public long save(XxlJobLog xxlJobLog);

    public int updateTriggerInfo(XxlJobLog xxlJobLog);

    public int updateHandleInfo(XxlJobLog xxlJobLog);

    public int delete(@Param("jobId") Long jobId);

    public Map<String, Object> findLogReport(@Param("from") Date from,
                                             @Param("to") Date to);

    public List<Long> findClearLogIds(@Param("jobGroup") Long jobGroup,
                                      @Param("jobId") Long jobId,
                                      @Param("clearBeforeTime") Date clearBeforeTime,
                                      @Param("clearBeforeNum") int clearBeforeNum,
                                      @Param("pagesize") int pagesize);

    public int clearLog(@Param("logIds") List<Long> logIds);

    public List<Long> findFailJobLogIds(@Param("pagesize") int pagesize);

    public int updateAlarmStatus(@Param("logId") long logId,
                                 @Param("oldAlarmStatus") int oldAlarmStatus,
                                 @Param("newAlarmStatus") int newAlarmStatus);

    public List<Long> findLostJobIds(@Param("losedTime") Date losedTime);

}
