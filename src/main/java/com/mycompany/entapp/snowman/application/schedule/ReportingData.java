/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.application.schedule;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Aggregate reporting data container.
 * Refactored to compose domain-specific reporting segments
 * (BusinessReportingData, HrReportingData, SystemReportingData)
 * instead of directly aggregating all domain model types.
 *
 * This eliminates the god-class pattern where a single class
 * imported and bundled every domain entity.
 */
public class ReportingData {
    private BusinessReportingData businessData;
    private HrReportingData hrData;
    private SystemReportingData systemData;

    public ReportingData() {
    }

    public ReportingData(BusinessReportingData businessData, HrReportingData hrData, SystemReportingData systemData) {
        this.businessData = businessData;
        this.hrData = hrData;
        this.systemData = systemData;
    }

    public BusinessReportingData getBusinessData() {
        return businessData;
    }

    public void setBusinessData(BusinessReportingData businessData) {
        this.businessData = businessData;
    }

    public HrReportingData getHrData() {
        return hrData;
    }

    public void setHrData(HrReportingData hrData) {
        this.hrData = hrData;
    }

    public SystemReportingData getSystemData() {
        return systemData;
    }

    public void setSystemData(SystemReportingData systemData) {
        this.systemData = systemData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReportingData that = (ReportingData) o;

        return new EqualsBuilder()
            .append(businessData, that.businessData)
            .append(hrData, that.hrData)
            .append(systemData, that.systemData)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(businessData)
            .append(hrData)
            .append(systemData)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("businessData", businessData)
            .append("hrData", hrData)
            .append("systemData", systemData)
            .toString();
    }
}
