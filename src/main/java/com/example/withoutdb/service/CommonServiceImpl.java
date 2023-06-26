package com.example.withoutdb.service;

import com.example.withoutdb.model.*;

import java.sql.*;
import java.util.List;

public class CommonServiceImpl  implements  CommonService {

    public void saveCommon(Common common) {
        try {
            Fnol fnol = common.getFnolData();
            Policyinformation policyinformation = common.getPolicyInfoData();
            LossSummary lossSummary = common.getLossData();
            Exposure exposure = common.getExposureData();
            DateTimeUtil dateTimeUtil = new DateTimeUtil();

            Connection con = DBConn.getMyConnection();
            System.out.println("Connection reached Common Service");

            PreparedStatement ps = con.prepareStatement("INSERT INTO NXT_Master (PolicyNumber, DateofLoss, LossLocation, TimeofLoss, Reportedby, DateReported, PolicyVerified, UnderwritingCompany, EffectiveDate, ExpirationDate, OriginalEffectiveDate, PolicyStatus, PolicyType, Name, Address, Phone, Adjuster, LossDescription, LossCause, OtherDescription, TypeofLoss, WeatherInvolved, WeatherDescription, RelationshipToInsured, LossAddress, Countries, City, Zipcode, State, LossParty, PrimaryCoverage, ExposuresStatus, CreationDate, Claimant, ClaimantType,  ExposureAddress) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, fnol.getPolicyNumber());
            ps.setDate(2, Date.valueOf(dateTimeUtil.toDate(fnol.getDateOfLoss())));
            ps.setString(3, fnol.getLossLocation());
            ps.setTime(4, Time.valueOf(dateTimeUtil.toTime(fnol.getLossTime())));
            ps.setString(5, fnol.getReportedBy());
            ps.setDate(6, Date.valueOf(dateTimeUtil.toDate(fnol.getDateOfReport())));

            ps.setString(7, policyinformation.getPolicyVerified());
            ps.setString(8, policyinformation.getUnderwriting());
            ps.setDate(9, Date.valueOf(dateTimeUtil.toDate(policyinformation.getEffectiveDate())));
            ps.setDate(10, Date.valueOf(dateTimeUtil.toDate(policyinformation.getExpirationDate())));
            ps.setDate(11, Date.valueOf(dateTimeUtil.toDate(policyinformation.getOriginalEffectiveDate())));
            ps.setString(12, policyinformation.getPolicyStatus());
            ps.setString(13, policyinformation.getPolicyType());
            ps.setString(14, policyinformation.getName());
            ps.setString(15, policyinformation.getAddress());
            ps.setString(16, policyinformation.getPrimaryPhone());

            ps.setString(17, lossSummary.getAdjuster());
            ps.setString(18, lossSummary.getLossDescription());
            ps.setString(19, lossSummary.getLossCause());
            ps.setString(20, lossSummary.getOtherDescription());
            ps.setString(21, lossSummary.getTypeOfLoss());
            ps.setString(22, lossSummary.getWeatherInvolved());
            ps.setString(23, lossSummary.getWeatherDescription());
            ps.setString(24, lossSummary.getRelationshipToInsured());
            ps.setString(25, lossSummary.getAddress1());
            ps.setString(26, lossSummary.getCountry());
            ps.setString(27, lossSummary.getCity());
            ps.setString(28, lossSummary.getZipCode());
            ps.setString(29, lossSummary.getState());


            ps.setString(30, exposure.getLossParty());
            ps.setString(31, exposure.getPrimaryCoverage());
            ps.setString(32, exposure.getStatus());
            ps.setDate(33, Date.valueOf(dateTimeUtil.toDate(exposure.getCreationDate())));
            ps.setString(34, exposure.getClaimant());
            ps.setString(35, exposure.getClaimantType());
            ps.setString(36, exposure.getAddress());

            ps.executeUpdate(); // Execute the insert statement

            System.out.println("Data inserted successfully,Inserted values: " + fnol.getPolicyNumber() + ", " +
                    dateTimeUtil.toDate(fnol.getDateOfLoss()) + ", " +
                    fnol.getLossLocation() + ", " +
                    dateTimeUtil.toTime(fnol.getLossTime()) + ", " +
                    fnol.getReportedBy() + ", " +
                    dateTimeUtil.toDate(fnol.getDateOfReport()) + ", " +
                    policyinformation.getPolicyVerified() + ", " +
                    policyinformation.getUnderwriting() + ", " +
                    dateTimeUtil.toDate(policyinformation.getEffectiveDate()) + ", " +
                    dateTimeUtil.toDate(policyinformation.getExpirationDate()) + ", " +
                    dateTimeUtil.toDate(policyinformation.getOriginalEffectiveDate()) + ", " +
                    policyinformation.getPolicyStatus() + ", " +
                    policyinformation.getPolicyType() + ", " +
                    policyinformation.getName() + ", " +
                    policyinformation.getAddress() + ", " +
                    policyinformation.getPrimaryPhone() + ", " +
                    lossSummary.getAdjuster() + ", " +
                    lossSummary.getLossDescription() + ", " +
                    lossSummary.getLossCause() + ", " +
                    lossSummary.getOtherDescription() + ", " +
                    lossSummary.getTypeOfLoss() + ", " +
                    lossSummary.getWeatherInvolved() + ", " +
                    lossSummary.getWeatherDescription() + ", " +
                    lossSummary.getRelationshipToInsured() + ", " +
                    lossSummary.getAddress1() + ", " +
                    lossSummary.getCountry() + ", " +
                    lossSummary.getCity() + ", " +
                    lossSummary.getZipCode() + ", " +
                    lossSummary.getState() + ", " +
                    lossSummary.getJurisdiction() + ", " +
                    exposure.getLossParty() + ", " +
                    exposure.getPrimaryCoverage() + ", " +
                    exposure.getStatus() + ", " +
                    dateTimeUtil.toDate(exposure.getCreationDate()) + ", " +
                    exposure.getClaimant() + ", " +
                    exposure.getClaimantType() + ", " +
                    exposure.getAddress());
        } catch (SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in saveFnol method " + e);

        }
    }

    @Override
    public List<Common> getAllcommons() {
        return null;
    }
}