public class CMaisonUser extends CMaison {
public CMaisonUser() {
super();
CAutreAppareil  ll = new CAutreAppareil ("ll", TypeAppareil.AUTRE_APPAREIL_LL);
ma_liste_appareils.add(ll);
CEclairage rad1 = new CEclairage("rad1",TypeAppareil.CHAUFFAGE);
ma_liste_appareils.add(rad1);
CAutreAppareil  lv = new CAutreAppareil ("lv", TypeAppareil.AUTRE_APPAREIL_LV);
ma_liste_appareils.add(lv);
CVoletFenetre fen = new CVoletFenetre("fen",TypeAppareil.FENETRE);
ma_liste_appareils.add(fen);
CAutreAppareil  matv = new CAutreAppareil ("matv", TypeAppareil.AUTRE_APPAREIL_TV);
ma_liste_appareils.add(matv);
CAutreAppareil  proj = new CAutreAppareil ("proj", TypeAppareil.AUTRE_APPAREIL_VP);
ma_liste_appareils.add(proj);
CEclairage e1 = new CEclairage("e1",TypeAppareil.ECLAIRAGE);
ma_liste_appareils.add(e1);
CEclairage e2 = new CEclairage("e2",TypeAppareil.ECLAIRAGE);
ma_liste_appareils.add(e2);
CEclairage e3 = new CEclairage("e3",TypeAppareil.ECLAIRAGE);
ma_liste_appareils.add(e3);
CAutreAppareil  tv1 = new CAutreAppareil ("tv1", TypeAppareil.AUTRE_APPAREIL_TV);
ma_liste_appareils.add(tv1);
CAlarme a1 = new CAlarme("a1",TypeAppareil.ALARME);
ma_liste_appareils.add(a1);
CAlarme a2 = new CAlarme("a2",TypeAppareil.ALARME);
ma_liste_appareils.add(a2);
CAutreAppareil  tv2 = new CAutreAppareil ("tv2", TypeAppareil.AUTRE_APPAREIL_TV);
ma_liste_appareils.add(tv2);
CAlarme a3 = new CAlarme("a3",TypeAppareil.ALARME);
ma_liste_appareils.add(a3);
CAutreAppareil  cafe = new CAutreAppareil ("cafe", TypeAppareil.AUTRE_APPAREIL_CAFE);
ma_liste_appareils.add(cafe);
CAutreAppareil  port = new CAutreAppareil ("port", TypeAppareil.AUTRE_APPAREIL_PORTAIL);
ma_liste_appareils.add(port);
CVoletFenetre  v1 = new CVoletFenetre ("v1",TypeAppareil.VOLET);
ma_liste_appareils.add(v1);
CVoletFenetre  v2 = new CVoletFenetre ("v2",TypeAppareil.VOLET);
ma_liste_appareils.add(v2);
CVoletFenetre  v3 = new CVoletFenetre ("v3",TypeAppareil.VOLET);
ma_liste_appareils.add(v3);
CVoletFenetre  v4 = new CVoletFenetre ("v4",TypeAppareil.VOLET);
ma_liste_appareils.add(v4);
CAutreAppareil  hf = new CAutreAppareil ("hf", TypeAppareil.AUTRE_APPAREIL_HIFI);
ma_liste_appareils.add(hf);
CEclairage r1 = new CEclairage("r1",TypeAppareil.CHAUFFAGE);
ma_liste_appareils.add(r1);
CVoletFenetre  v5 = new CVoletFenetre ("v5",TypeAppareil.VOLET);
ma_liste_appareils.add(v5);
CEnsAppareil elec_salon = new CEnsAppareil("elec_salon");
elec_salon.addAppareil(matv);
elec_salon.addAppareil(proj);
elec_salon.addAppareil(tv1);
ma_liste_ens_appareils.add(elec_salon);
CEnsAppareil mon_eclairage_salon = new CEnsAppareil("mon_eclairage_salon");
mon_eclairage_salon.addAppareil(e2);
mon_eclairage_salon.addAppareil(e3);
ma_liste_ens_appareils.add(mon_eclairage_salon);
CInterface tel1 = new CInterface("tel1",TypeInterface.TELEPHONE);
ma_liste_interfaces.add(tel1);
CInterface   b2 = new CInterface("b2",TypeInterface.INTERRUPTEUR);
ma_liste_interfaces.add(b2);
CInterface   b3 = new CInterface("b3",TypeInterface.INTERRUPTEUR);
ma_liste_interfaces.add(b3);
CInterface   b4 = new CInterface("b4",TypeInterface.INTERRUPTEUR);
ma_liste_interfaces.add(b4);
CInterface zap = new CInterface("zap",TypeInterface.TELECOMMANDE);
ma_liste_interfaces.add(zap);
CInterface tab1 = new CInterface("tab1",TypeInterface.TABLETTE);
ma_liste_interfaces.add(tab1);
CInterface tab2 = new CInterface("tab2",TypeInterface.TABLETTE);
ma_liste_interfaces.add(tab2);
CInterface t1 = new CInterface("t1",TypeInterface.MOBILE);
ma_liste_interfaces.add(t1);
CInterface   b1 = new CInterface("b1",TypeInterface.INTERRUPTEUR);
ma_liste_interfaces.add(b1);

 String bonjour_contenu  = " for(CAppareil appareil0 : this.l_appareils) {  if (appareil0.typeAppareil.equals(TypeAppareil.VOLET)) {    for(CAppareil appareil1 : this.l_appareils){   if (appareil1.typeAppareil.equals(TypeAppareil.VOLET)){ if (appareil1.etatAppareil.equals(TypeEtatAppareil.FERME)) {  appareil1.appliquer(TypeActionAppareil.OUVRIR);   }}} } } for(CAppareil appareil : this.l_appareils)   {  if (appareil.getNomAppareil().equals(\"e1\"))     appareil.appliquer(TypeActionAppareil.ETEINDRE); }  for(CAppareil appareil : this.l_appareils)   {  if (appareil.getNomAppareil().equals(\"cafe\"))     appareil.appliquer(TypeActionAppareil.ALLUMER); }  for(CAppareil appareil0 : this.l_appareils){   if (appareil0.getNomAppareil().equals(\"rad1\")){ if (appareil0.etatAppareil.equals(TypeEtatAppareil.ETEINT)) {  appareil0.appliquer(TypeActionAppareil.ALLUMER);   }}} for(CAppareil appareil : this.l_appareils)   {  if (appareil.getNomAppareil().equals(\"hf\"))     appareil.appliquer(TypeActionAppareil.ALLUMER); }  " ; 
CScenario bonjour = new CScenario("bonjour",bonjour_contenu ) ;
ma_liste_scenarios.add(bonjour); 

 String soiree_contenu  = " for(CAppareil appareil0 : this.l_appareils) {  if (appareil0.typeAppareil.equals(TypeAppareil.VOLET)) {   appareil0.appliquer(TypeActionAppareil.FERMER);  } }for(CEnsAppareil ensAppareil0 : this.l_ensembles){  if (ensAppareil0.nomEnsAppareil.equals(\"mon_eclairage_salon\")) { for(CAppareil appareil0 : ensAppareil0.lAppareils) appareil0.appliquer(TypeActionAppareil.ALLUMER); } } " ; 
CScenario soiree = new CScenario("soiree",soiree_contenu ) ;
ma_liste_scenarios.add(soiree); 

 String soiree_musique_contenu  = " this.execScenarioNum(1);  for(CAppareil appareil : this.l_appareils)   {  if (appareil.getNomAppareil().equals(\"hf\"))     appareil.appliquer(TypeActionAppareil.ALLUMER); }  " ; 
CScenario soiree_musique = new CScenario("soiree_musique",soiree_musique_contenu ) ;
ma_liste_scenarios.add(soiree_musique); 

 String depart_contenu  = " for(CAppareil appareil0 : this.l_appareils) {  if (appareil0.typeAppareil.equals(TypeAppareil.VOLET)) {   appareil0.appliquer(TypeActionAppareil.FERMER);  } } for(CAppareil appareil0 : this.l_appareils) {  if (appareil0.typeAppareil.equals(TypeAppareil.ECLAIRAGE)) {   appareil0.appliquer(TypeActionAppareil.ETEINDRE);  } } for(CAppareil appareil0 : this.l_appareils){   if (appareil0.getNomAppareil().equals(\"fen\")){ if (appareil0.etatAppareil.equals(TypeEtatAppareil.FERME)) {  appareil0.appliquer(TypeActionAppareil.ALLUMER);   }  else {   System.out.println( \"Attention : la fenêtre  est ouverte !\") ;  } }}for(CAppareil appareil0 : this.l_appareils){  if (appareil0.estTypeAutreAppareil())  { appareil0.appliquer(TypeActionAppareil.ETEINDRE);  } } " ; 
CScenario depart = new CScenario("depart",depart_contenu ) ;
ma_liste_scenarios.add(depart); 

 String test_contenu  = " for(CAppareil appareil0 : this.l_appareils) {  if (appareil0.typeAppareil.equals(TypeAppareil.AUTRE_APPAREIL_TV)) {   appareil0.appliquer(TypeActionAppareil.ALLUMER);  } } this.execScenarioNum(2);  for(CAppareil appareil0 : this.l_appareils){   if (appareil0.getNomAppareil().equals(\"a1\")){ if (appareil0.etatAppareil.equals(TypeEtatAppareil.ETEINT)) {  appareil0.appliquer(TypeActionAppareil.ALLUMER_PARTIEL);   }}} for(CAppareil appareil0 : this.l_appareils){   if (appareil0.getNomAppareil().equals(\"a1\")){ if (appareil0.etatAppareil.equals(TypeEtatAppareil.DEMI)) {  appareil0.appliquer(TypeActionAppareil.ALLUMER);   }  else {  for(CAppareil appareil1 : this.l_appareils){   if (appareil1.getNomAppareil().equals(\"a1\")){ if (appareil1.etatAppareil.equals(TypeEtatAppareil.ALLUME)) {  appareil1.appliquer(TypeActionAppareil.ETEINDRE);   }  else {  for(CAppareil appareil : this.l_appareils)   {  if (appareil.getNomAppareil().equals(\"a2\"))     appareil.appliquer(TypeActionAppareil.ALLUMER); } } }}} }} for(CAppareil appareil0 : this.l_appareils){   if (appareil0.getNomAppareil().equals(\"r1\")){ if (appareil0.etatAppareil.equals(TypeEtatAppareil.ECO)) {  appareil0.appliquer(TypeActionAppareil.ALLUMER);   }}} for(CAppareil appareil0 : this.l_appareils){   if (appareil0.getNomAppareil().equals(\"r1\")){ if (appareil0.etatAppareil.equals(TypeEtatAppareil.ETEINT)) {  appareil0.appliquer(TypeActionAppareil.ALLUMER_ECO);   }  else {  for(CAppareil appareil1 : this.l_appareils){   if (appareil1.getNomAppareil().equals(\"r1\")){ if (appareil1.etatAppareil.equals(TypeEtatAppareil.ALLUME)) {  appareil1.appliquer(TypeActionAppareil.ETEINDRE);   }  else {   System.out.println(\" bip !\") ;  } }}} }} for(CAppareil appareil0 : this.l_appareils){   if (appareil0.getNomAppareil().equals(\"fen\")){ if (appareil0.etatAppareil.equals(TypeEtatAppareil.OUVERT)) {   System.out.println(\"fenêtre ouverte !\") ;  }}} for(CAppareil appareil0 : this.l_appareils){   if (appareil0.getNomAppareil().equals(\"cafe\")){ if (appareil0.etatAppareil.equals(TypeEtatAppareil.ALLUME)) {  appareil0.appliquer(TypeActionAppareil.ETEINDRE);   }}} for(CAppareil appareil0 : this.l_appareils){   if (appareil0.getNomAppareil().equals(\"cafe\")){ if (appareil0.etatAppareil.equals(TypeEtatAppareil.ETEINT)) {  appareil0.appliquer(TypeActionAppareil.ALLUMER);   }}} " ; 
CScenario test = new CScenario("test",test_contenu ) ;
ma_liste_scenarios.add(test); 

 String test2_contenu  = " for(CAppareil appareil0 : this.l_appareils){   if (appareil0.getNomAppareil().equals(\"e1\")){ if (appareil0.etatAppareil.equals(TypeEtatAppareil.ETEINT)) {  appareil0.appliquer(TypeActionAppareil.ALLUMER);   }  else {  for(CAppareil appareil1 : this.l_appareils){   if (appareil1.getNomAppareil().equals(\"e1\")){ if (appareil1.etatAppareil.equals(TypeEtatAppareil.DEMI)) {  appareil1.appliquer(TypeActionAppareil.ETEINDRE);   }}}} }} for(CAppareil appareil0 : this.l_appareils){   if (appareil0.getNomAppareil().equals(\"e2\")){ if (appareil0.etatAppareil.equals(TypeEtatAppareil.ALLUME)) {  appareil0.appliquer(TypeActionAppareil.TAMISER);   }}} for(CAppareil appareil0 : this.l_appareils){   if (appareil0.getNomAppareil().equals(\"v1\")){ if (appareil0.etatAppareil.equals(TypeEtatAppareil.OUVERT)) {  appareil0.appliquer(TypeActionAppareil.FERMER_PARTIEL);   }}} for(CAppareil appareil0 : this.l_appareils){   if (appareil0.getNomAppareil().equals(\"v1\")){ if (appareil0.etatAppareil.equals(TypeEtatAppareil.FERME)) {  appareil0.appliquer(TypeActionAppareil.OUVRIR_PARTIEL);     System.out.println(\" alors \") ;  }  else {  for(CAppareil appareil1 : this.l_appareils){   if (appareil1.getNomAppareil().equals(\"v1\")){ if (appareil1.etatAppareil.equals(TypeEtatAppareil.DEMI)) {  appareil1.appliquer(TypeActionAppareil.FERMER);   }  else {  for(CAppareil appareil : this.l_appareils)   {  if (appareil.getNomAppareil().equals(\"v1\"))     appareil.appliquer(TypeActionAppareil.OUVRIR); }   System.out.println(\" sinon \") ;  } }}} }} " ; 
CScenario test2 = new CScenario("test2",test2_contenu ) ;
ma_liste_scenarios.add(test2); 
CProgrammation p1 = new CProgrammation("soiree_musique");
CDate p1d1 = new CDate(2012,11,21,19,30);
p1.addDate(p1d1);
CDate p1d2 = new CDate(2012,-1,20,19,30);
p1.addDate(p1d2);
ma_liste_programmations.add(p1);
CProgrammation p2 = new CProgrammation("soiree");
CDate p2d1 = new CDate(2012,-1,21,18,0);
p2.addDate(p2d1);
ma_liste_programmations.add(p2);
b1.addScenarioAssocie("bonjour");
monHabitat = new HabitatSpecific(ma_liste_appareils,ma_liste_ens_appareils, ma_liste_scenarios,ma_liste_interfaces, ma_liste_programmations);
}
}