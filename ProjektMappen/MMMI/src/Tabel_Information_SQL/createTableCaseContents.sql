-- Query to create table case contents
CREATE TABLE Case_Contents (caseContentID SERIAL NOT NULL, CasecaseID varchar(255) NOT NULL, dateStamp timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, carriage varchar(255), treament varchar(255), cashBenefit varchar(255), Control varchar(255), stay varchar(255), practicalHelp varchar(255), personalHelp varchar(255), protectedEmploymentBenefit varchar(255), dayRelief varchar(255), socialPedogogicalHelp varchar(255), personalHelpScheme varchar(255), ambulantTreatment varchar(255), outpatientOffers varchar(255), housingOfferForAdults varchar(255), extendedHousingOfferForAdults varchar(255), inquiryFrom varchar(255), inquiryFromText text, guardianShip varchar(255), guardianShipText text, representation varchar(255), representationText text, rightsAndDuties varchar(255), rightsAndDutiesText text, agreementsWithCitizenText text, consent varchar(255), getInfo varchar(255), getInfoText text, citizenSpecialCircumstancesText text, otherActingCommune varchar(255), otherActingCommuneText text, PRIMARY KEY (caseContentID));
-- Query to delete/drop table
DROP TABLE IF EXISTS Case_Contents CASCADE;