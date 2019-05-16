package MMMI.Data_layer;

import mmmi.Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHandler extends DatabaseConnection implements IDataHandler {

    @Override
    public Case readCase(String caseID) {

        String getCaseQuery = "SELECT *"
                + "FROM Case = c"
                + "RIGHT JOIN cc1 ON (c." + caseID + " = cc1.casecaseid)"
                + "RIGHT JOIN cc1 ON (c." + caseID + " = cc2.casecaseid)";
        List<String> columnNames = new ArrayList<>();
        List<Integer> requstingCitizenIDs = new ArrayList<>();
        Map<String, String> columnToValuesMap = new HashMap<>();

        Integer regardingCitizenID = 0;
        try {

            connectToDB();
            PreparedStatement statement;
            statement = dbConnection.prepareStatement(getCaseQuery);
            ResultSet rs = statement.executeQuery(getCaseQuery);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnNames.add(columnName);

                //Load the Map initially with keys(columnnames) and empty value
                columnToValuesMap.put(columnName, "");
            }
            while (rs.next()) {

                for (String columnName : columnNames) {
                    if (columnName.equalsIgnoreCase("citizenrequestingcitizenid")) {
                        requstingCitizenIDs.add(rs.getInt(Integer.parseInt(columnName)));
                    } else if (columnName.equalsIgnoreCase("citizenid")) {
                        regardingCitizenID = rs.getInt(Integer.parseInt(columnName));
                    }
                    //Get the list mapped to column name
                    String columnDataList = columnToValuesMap.get(columnName);

                    //add the updated list of column data to the map now
                    columnToValuesMap.put(columnName, columnDataList);
                }

            }

            // String caseID, String caseStatus, int regardingCitizenID, List<Integer> requestingCitizens, Map<String, String> caseContent
        } catch (SQLException e) {
        }
        //List<Integer> rc = caze.getRequestingCitizen();

        return new Case(caseID, "Igang", regardingCitizenID, requstingCitizenIDs, columnToValuesMap);

    }

    @Override
    public Citizen readCitizen(int citizenID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee readEmployee(int employeeID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean writeCase(Case theCase) {
        //casecontentidInfo, , casecaseidInfo, datestampInfo,
        String carriageInfo, treamentcarriageInfo, treamentInfo, cashbenefitInfo, controlInfo, stayInfo, practicalhelpInfo, personalhelpInfo,
                protectedemploymentbenefitInfo,
                dayreliefInfo, socialpedogogicalhelpInfo, personalhelpschemeInfo, ambulanttreatmentInfo, outpatientoffersInfo, housingofferforadultsInfo,
                extendedhousingofferforadultsInfo, inquiryfromInfo, inquiryfromtextInfo, guardianshipInfo, guardianshiptextInfo, representationInfo,
                representationtextInfo, rightsanddutiesInfo, rightsanddutiestextInfo, agreementswithcitizentextInfo, consentInfo, getinfoInfo, getinfotextInfo,
                citizenspecialcircumstancestextInfo, otheractingcommuneInfo, otheractingcommunetextInfo;
        carriageInfo = treamentcarriageInfo = treamentInfo = cashbenefitInfo = controlInfo = stayInfo = practicalhelpInfo = personalhelpInfo
                = protectedemploymentbenefitInfo
                = dayreliefInfo = socialpedogogicalhelpInfo = personalhelpschemeInfo = ambulanttreatmentInfo = outpatientoffersInfo = housingofferforadultsInfo
                = extendedhousingofferforadultsInfo = inquiryfromInfo = inquiryfromtextInfo = guardianshipInfo = guardianshiptextInfo = representationInfo
                = representationtextInfo = rightsanddutiesInfo = rightsanddutiestextInfo = agreementswithcitizentextInfo = consentInfo = getinfoInfo = getinfotextInfo
                = citizenspecialcircumstancestextInfo = otheractingcommuneInfo = otheractingcommunetextInfo = "";

        connectToDB();
        try {
            PreparedStatement statement;

            for (Map.Entry<String, String> entry : theCase.getCaseContent().entrySet()) {
                if (entry.getKey().equalsIgnoreCase("carriage")) {
                    carriageInfo = entry.getValue();
                } else if (entry.getKey().equalsIgnoreCase("treament")) {
                    treamentInfo = entry.getValue();
                } else if (entry.getKey().equalsIgnoreCase("cashbenefit")) {
                    cashbenefitInfo = entry.getValue();
                }
            }
            statement = dbConnection.prepareStatement("INSERT INTO case_contents"
                    + "(casecontentid, , casecaseid, datestamp, carriage, treament, cashbenefit, control, stay, practicalhelp, personalhelp, protectedemploymentbenefit,"
                    + "dayrelief, socialpedogogicalhelp, personalhelpscheme, ambulanttreatment, outpatientoffers, housingofferforadults,"
                    + "extendedhousingofferforadults, inquiryfrom, inquiryfromtext, guardianship, guardianshiptext, representation,"
                    + "representationtext, rightsandduties, rightsanddutiestext, agreementswithcitizentext, consent, getinfo, getinfotext,"
                    + "citizenspecialcircumstancestext, otheractingcommune, otheractingcommunetext)"
                    + "VALUES"
                    + "('?','?','?'"
                    + "'?', '?', '?')");

            statement.setString(4, carriageInfo);

        } catch (SQLException e) {

            System.out.println("Exception at writeCase:mmmi.Data_layer.DataHandler"
                    + " a database access error occured "
                    + " or this method is called on a closed connection "
                    + "(setString) parameterIndex does not correspond to a parameter marker in the SQL statement"
                    + e.getLocalizedMessage());
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean writeCitizen(Citizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean writeEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCitizen(Citizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Case createCase() {
        List<Integer> requestingCitizen = new ArrayList<>();
        Map<String, String> caseContent = new HashMap<>();

        return new Case("", "Igang", 0, requestingCitizen, caseContent);
    }

    @Override
    public Citizen createCitizen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SearchCase> search(String searchKey, String searchValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
