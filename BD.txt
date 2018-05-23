DROP DATABASE IF EXISTS MLR4;

CREATE DATABASE IF NOT EXISTS MLR4;
USE MLR4;
# -----------------------------------------------------------------------------
#       TABLE : UTILISATEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS UTILISATEUR
 (
   ID_PERSONNE INTEGER NOT NULL  ,
   ID_ROLE BIGINT(4) NOT NULL  ,
   MATRICULE VARCHAR(128) NOT NULL  ,
   NOM VARCHAR(50) NOT NULL  ,
   PRENOM VARCHAR(20) NULL  ,
   EMAIL VARCHAR(50) NULL  ,
   NUMERO_TELEPHONE INTEGER NULL  ,
   RUE VARCHAR(20) NULL  ,
   NUMERO_RUE INTEGER NULL  ,
   CODE_POSTAL INTEGER NULL  ,
   LOCALITE VARCHAR(15) NULL  ,
   EST_MASCULIN BOOL NOT NULL  ,
   DATE_NAISSANCE DATE NULL  ,
   COMPTE VARCHAR(128) NOT NULL  ,
   MOT_DE_PASSE VARCHAR(128) NOT NULL  ,
   URL_PHOTO VARCHAR(128) NULL  
   , PRIMARY KEY (ID_PERSONNE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ETUDIANT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ETUDIANT
 (
   ID_ETUDIANT BIGINT(4) NOT NULL  ,
   ID_PERSONNE INTEGER NOT NULL  
   , PRIMARY KEY (ID_ETUDIANT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : TYPE_SALLE_DE_CLASSE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS TYPE_SALLE_DE_CLASSE
 (
   ID_TYPE INTEGER NOT NULL  ,
   NOM_TYPE VARCHAR(22) NULL  
   , PRIMARY KEY (ID_TYPE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : MENU
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS MENU
 (
   ID_MENU BIGINT(4) NOT NULL  ,
   CODE VARCHAR(128) NOT NULL  ,
   LIBELLE CHAR(32) NULL  
   , PRIMARY KEY (ID_MENU) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ANNEE_ACADEMIQUE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ANNEE_ACADEMIQUE
 (
   ID_ANNEE_ACADEMIQUE BIGINT(4) NOT NULL  ,
   CODE VARCHAR(128) NOT NULL  ,
   INTITULE VARCHAR(128) NULL  
   , PRIMARY KEY (ID_ANNEE_ACADEMIQUE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : DEPARTEMENTS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS DEPARTEMENTS
 (
   ID_DEPARTEMENT INTEGER NOT NULL  ,
   CODE VARCHAR(20) NOT NULL  ,
   LIBELLE VARCHAR(128) NULL  
   , PRIMARY KEY (ID_DEPARTEMENT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : SPECIALITES
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SPECIALITES
 (
   ID_SPECIALITE INTEGER NOT NULL  ,
   ID_DEPARTEMENT INTEGER NOT NULL  ,
   NOM_SPECIALITE VARCHAR(20) NOT NULL  
   , PRIMARY KEY (ID_SPECIALITE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CLASSE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CLASSE
 (
   ID_CLASSE BIGINT(4) NOT NULL  ,
   ID_SPECIALITE INTEGER NOT NULL  ,
   ID_NIVEAU BIGINT(4) NOT NULL  ,
   CODE VARCHAR(128) NOT NULL  ,
   INTITULE VARCHAR(128) NULL  
   , PRIMARY KEY (ID_CLASSE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CATEGORIE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CATEGORIE
 (
   ID_CATEGORIE BIGINT(4) NOT NULL  ,
   CODE VARCHAR(128) NOT NULL  ,
   INTITULE VARCHAR(128) NULL  
   , PRIMARY KEY (ID_CATEGORIE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : SALLE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SALLE
 (
   ID_SALLE INTEGER NOT NULL  ,
   ID_TYPE INTEGER NOT NULL  ,
   CODE VARCHAR(128) NOT NULL  ,
   INTITULE VARCHAR(128) NULL  ,
   NOMBRE_DE_PLACES INTEGER NULL  
   , PRIMARY KEY (ID_SALLE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PROGRAMME
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PROGRAMME
 (
   ID_PROGRAMME BIGINT(4) NOT NULL  ,
   ID_SALLE INTEGER NOT NULL  ,
   ID_COURS INTEGER NOT NULL  ,
   ID_ANNEE_ACADEMIQUE BIGINT(4) NOT NULL  ,
   DATE_PROGRAMME DATETIME NOT NULL  
   , PRIMARY KEY (ID_PROGRAMME) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : NIVEAU
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS NIVEAU
 (
   ID_NIVEAU BIGINT(4) NOT NULL  ,
   CODE VARCHAR(128) NOT NULL  ,
   INTITULE VARCHAR(128) NULL  
   , PRIMARY KEY (ID_NIVEAU) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ROLE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ROLE
 (
   ID_ROLE BIGINT(4) NOT NULL  ,
   CODE VARCHAR(128) NOT NULL  ,
   INTITULE VARCHAR(128) NULL  
   , PRIMARY KEY (ID_ROLE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : HISTORIQUE_CONNEXION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS HISTORIQUE_CONNEXION
 (
   ID_HISTORIQUE_CONNEXION BIGINT(4) NOT NULL  ,
   ID_PERSONNE INTEGER NOT NULL  ,
   DEBUT_SESSION DATETIME NOT NULL  ,
   FIN_SESSION DATETIME NULL  
   , PRIMARY KEY (ID_HISTORIQUE_CONNEXION) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ENSEIGNANT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ENSEIGNANT
 (
   ID_ENSEIGNANT BIGINT(4) NOT NULL  ,
   ID_DEPARTEMENT INTEGER NOT NULL  ,
   ID_PERSONNE INTEGER NOT NULL  ,
   TITRE VARCHAR(10) NULL  ,
   DATE_ARRIVEE DATE NOT NULL  
   , PRIMARY KEY (ID_ENSEIGNANT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : TYPES_DE_COURS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS TYPES_DE_COURS
 (
   ID_TYPE_COURS INTEGER NOT NULL  ,
   NOM_DU_TYPE VARCHAR(10) NOT NULL  
   , PRIMARY KEY (ID_TYPE_COURS) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : COURS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COURS
 (
   ID_COURS INTEGER NOT NULL  ,
   ID_TYPE_COURS INTEGER NOT NULL  ,
   ID_CATEGORIE BIGINT(4) NOT NULL  ,
   CODE VARCHAR(20) NOT NULL  ,
   INTITULE VARCHAR(128) NULL  
   , PRIMARY KEY (ID_COURS) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : SUIVRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SUIVRE
 (
   ID_COURS INTEGER NOT NULL  ,
   ID_ETUDIANT BIGINT(4) NOT NULL  ,
   ID_ANNEE_ACADEMIQUE BIGINT(4) NOT NULL  
   , PRIMARY KEY (ID_COURS,ID_ETUDIANT,ID_ANNEE_ACADEMIQUE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : SCOLARISE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SCOLARISE
 (
   ID_ETUDIANT BIGINT(4) NOT NULL  ,
   ID_CLASSE BIGINT(4) NOT NULL  ,
   ID_ANNEE_ACADEMIQUE BIGINT(4) NOT NULL  
   , PRIMARY KEY (ID_ETUDIANT,ID_CLASSE,ID_ANNEE_ACADEMIQUE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : DISPENSATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS DISPENSATION
 (
   ID_ENSEIGNANT BIGINT(4) NOT NULL  ,
   ID_COURS INTEGER NOT NULL  ,
   ID_ANNEE_ACADEMIQUE BIGINT(4) NOT NULL  ,
   COEF SMALLINT NULL  ,
   NOTE_MINIMAL DECIMAL(10,2) NULL  
   , PRIMARY KEY (ID_ENSEIGNANT,ID_COURS,ID_ANNEE_ACADEMIQUE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : AUTORISATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS AUTORISATION
 (
   ID_ROLE BIGINT(4) NOT NULL  ,
   ID_MENU BIGINT(4) NOT NULL  ,
   AJOUTER BOOL NOT NULL  ,
   MODIFIER BOOL NOT NULL  ,
   SUPPRIMER BOOL NOT NULL  
   , PRIMARY KEY (ID_ROLE,ID_MENU) 
 ) 
 comment = "";


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE UTILISATEUR 
  ADD FOREIGN KEY FK_UTILISATEUR_ROLE (ID_ROLE)
      REFERENCES ROLE (ID_ROLE) ;


ALTER TABLE ETUDIANT 
  ADD FOREIGN KEY FK_ETUDIANT_UTILISATEUR (ID_PERSONNE)
      REFERENCES UTILISATEUR (ID_PERSONNE) ;


ALTER TABLE SPECIALITES 
  ADD FOREIGN KEY FK_SPECIALITES_DEPARTEMENTS (ID_DEPARTEMENT)
      REFERENCES DEPARTEMENTS (ID_DEPARTEMENT) ;


ALTER TABLE CLASSE 
  ADD FOREIGN KEY FK_CLASSE_SPECIALITES (ID_SPECIALITE)
      REFERENCES SPECIALITES (ID_SPECIALITE) ;


ALTER TABLE CLASSE 
  ADD FOREIGN KEY FK_CLASSE_NIVEAU (ID_NIVEAU)
      REFERENCES NIVEAU (ID_NIVEAU) ;


ALTER TABLE SALLE 
  ADD FOREIGN KEY FK_SALLE_TYPE_SALLE_DE_CLASSE (ID_TYPE)
      REFERENCES TYPE_SALLE_DE_CLASSE (ID_TYPE) ;


ALTER TABLE PROGRAMME 
  ADD FOREIGN KEY FK_PROGRAMME_SALLE (ID_SALLE)
      REFERENCES SALLE (ID_SALLE) ;


ALTER TABLE PROGRAMME 
  ADD FOREIGN KEY FK_PROGRAMME_COURS (ID_COURS)
      REFERENCES COURS (ID_COURS) ;


ALTER TABLE PROGRAMME 
  ADD FOREIGN KEY FK_PROGRAMME_ANNEE_ACADEMIQUE (ID_ANNEE_ACADEMIQUE)
      REFERENCES ANNEE_ACADEMIQUE (ID_ANNEE_ACADEMIQUE) ;


ALTER TABLE HISTORIQUE_CONNEXION 
  ADD FOREIGN KEY FK_HISTORIQUE_CONNEXION_UTILISATEUR (ID_PERSONNE)
      REFERENCES UTILISATEUR (ID_PERSONNE) ;


ALTER TABLE ENSEIGNANT 
  ADD FOREIGN KEY FK_ENSEIGNANT_DEPARTEMENTS (ID_DEPARTEMENT)
      REFERENCES DEPARTEMENTS (ID_DEPARTEMENT) ;


ALTER TABLE ENSEIGNANT 
  ADD FOREIGN KEY FK_ENSEIGNANT_UTILISATEUR (ID_PERSONNE)
      REFERENCES UTILISATEUR (ID_PERSONNE) ;


ALTER TABLE COURS 
  ADD FOREIGN KEY FK_COURS_TYPES_DE_COURS (ID_TYPE_COURS)
      REFERENCES TYPES_DE_COURS (ID_TYPE_COURS) ;


ALTER TABLE COURS 
  ADD FOREIGN KEY FK_COURS_CATEGORIE (ID_CATEGORIE)
      REFERENCES CATEGORIE (ID_CATEGORIE) ;


ALTER TABLE SUIVRE 
  ADD FOREIGN KEY FK_SUIVRE_COURS (ID_COURS)
      REFERENCES COURS (ID_COURS) ;


ALTER TABLE SUIVRE 
  ADD FOREIGN KEY FK_SUIVRE_ETUDIANT (ID_ETUDIANT)
      REFERENCES ETUDIANT (ID_ETUDIANT) ;


ALTER TABLE SUIVRE 
  ADD FOREIGN KEY FK_SUIVRE_ANNEE_ACADEMIQUE (ID_ANNEE_ACADEMIQUE)
      REFERENCES ANNEE_ACADEMIQUE (ID_ANNEE_ACADEMIQUE) ;


ALTER TABLE SCOLARISE 
  ADD FOREIGN KEY FK_SCOLARISE_ETUDIANT (ID_ETUDIANT)
      REFERENCES ETUDIANT (ID_ETUDIANT) ;


ALTER TABLE SCOLARISE 
  ADD FOREIGN KEY FK_SCOLARISE_CLASSE (ID_CLASSE)
      REFERENCES CLASSE (ID_CLASSE) ;


ALTER TABLE SCOLARISE 
  ADD FOREIGN KEY FK_SCOLARISE_ANNEE_ACADEMIQUE (ID_ANNEE_ACADEMIQUE)
      REFERENCES ANNEE_ACADEMIQUE (ID_ANNEE_ACADEMIQUE) ;


ALTER TABLE DISPENSATION 
  ADD FOREIGN KEY FK_DISPENSATION_ENSEIGNANT (ID_ENSEIGNANT)
      REFERENCES ENSEIGNANT (ID_ENSEIGNANT) ;


ALTER TABLE DISPENSATION 
  ADD FOREIGN KEY FK_DISPENSATION_COURS (ID_COURS)
      REFERENCES COURS (ID_COURS) ;


ALTER TABLE DISPENSATION 
  ADD FOREIGN KEY FK_DISPENSATION_ANNEE_ACADEMIQUE (ID_ANNEE_ACADEMIQUE)
      REFERENCES ANNEE_ACADEMIQUE (ID_ANNEE_ACADEMIQUE) ;


ALTER TABLE AUTORISATION 
  ADD FOREIGN KEY FK_AUTORISATION_ROLE (ID_ROLE)
      REFERENCES ROLE (ID_ROLE) ;


ALTER TABLE AUTORISATION 
  ADD FOREIGN KEY FK_AUTORISATION_MENU (ID_MENU)
      REFERENCES MENU (ID_MENU) ;

