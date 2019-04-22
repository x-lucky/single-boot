/*
 * 天虹商场股份有限公司版权所有.
 */
package com.ratel.single.single;

/**
 * 类说明
 * <p>
 *
 * @author niexiang
 * @version 1.0.0
 * @date 2019/4/22
 */
public class SchoolInfo {

    private String schoolName;
    private String schoolLocation;

    private String batch;

    /**
     * 分数线
     */
    private String scoreLimit;

    /**
     * 高校平均分
     */
    private String schoolAverage;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getScoreLimit() {
        return scoreLimit;
    }

    public void setScoreLimit(String scoreLimit) {
        this.scoreLimit = scoreLimit;
    }

    public String getSchoolAverage() {
        return schoolAverage;
    }

    public void setSchoolAverage(String schoolAverage) {
        this.schoolAverage = schoolAverage;
    }

    @Override
    public String toString() {
        return "SchoolInfo{" +
                "schoolName='" + schoolName + '\'' +
                ", schoolLocation='" + schoolLocation + '\'' +
                ", batch='" + batch + '\'' +
                ", scoreLimit='" + scoreLimit + '\'' +
                ", schoolAverage='" + schoolAverage + '\'' +
                '}';
    }
}
