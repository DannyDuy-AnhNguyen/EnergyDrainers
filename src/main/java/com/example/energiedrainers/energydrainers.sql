CREATE TABLE klant(
	KlantID char(5) NOT NULL auto_increment,
    Telefoonnummer varchar(10),
    Voornaam varchar(40) NOT NULL,
    Achternaam varchar(40) NOT NULL,
    Gebruikersnaam varchar(40) NOT NULL,
    Wachtwoord varchar(255) NOT NULL,
    PRIMARY KEY(KlantID)
);

CREATE TABLE Tracker(
	TrackerID char(7),
    PRIMARY KEY(TrackerID),
    FOREIGN KEY(KlantID) references klant(KlantID)
);

CREATE TABLE Meting(
	MetingID int NOT NULL auto_increment,
    Tijdstip datetime NOT NULL,
    HOEK_kantelservo int,
    HOEK_draaiservo int,
    LDR_BovenRechts int,
    LDR_BovenLinks int,
    LDR_OnderRechts int,
    LDR_OnderLinks int,
    PRIMARY KEY(MetingID),
    FOREIGN KEY(TrackerID) references Tracker(TrackerID)
);