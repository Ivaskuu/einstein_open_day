package com.skuu.einsteinopenday;

import com.google.android.gms.maps.model.LatLng;
/**
 * Created by Adrian on 14/11/2017.
 */

public class ListaAule
{
    public static Aula[] adule = {
            new Aula("Lab Disegno 2", 3, new LatLng(45.616727, 9.383946),
                    new Attivita
                                    ("Laboratorio di manipolazione argilla",
                                            "Esperto: Annapina")
                    ),
            new Aula(28, 3, new LatLng(45.616777, 9.384078),
                    new Attivita
                            ("Salone di Pittura – Stampatore",
                                    "Esperto: Paolo Sgroi")
            ),
            new Aula("Aula 3.0", 3, new LatLng(45.616832, 9.384237),
                    new Attivita
                            ("Laboratorio grafico-multimediale. Redazione aperta giornalino scolastico. I nostri video.",
                                    "Prof. Imperatore - Esperto: Andrea Ligabo")
            ),
            new Aula(25, 3, new LatLng(45.616985, 9.384135),
                    new Attivita
                            ("Immagini e parole: lettura di un’opera d’arte",
                                    "Prof. Tresoldi")
            ),
            new Aula(12, 2, new LatLng(45.616940, 9.383257),
                    new Attivita
                            ("Presentazione Liceo Scienze applicate",
                                    "Prof. Silva Marina")
            ),
            new Aula(2, 2, new LatLng(45.616730, 9.383149),
                    new Attivita
                            ("Presentazione Indirizzo Biologico-Sanitario",
                                    "Prof. Erba")
            ),
            /*new Aula("Lab. Chimica Fisica", 2, new LatLng(45.616727, 9.383946), // TODO
                    new Attivita
                            ("Dalle reazioni alla corrente elettrica",
                                    "Prof. Siragusa - Prof. Gazzaneo")
            ),*/
            new Aula("Lab. di Chimica", 2, new LatLng(45.616778, 9.382995),
                    new Attivita
                            ("Dai colori alla chimica in cucina",
                                    "Prof. Tornaghi")
            ),
            new Aula("Lab. Chimica Organica", 2, new LatLng(45.616811, 9.383092),
                    new Attivita
                            ("I profumi e gli olii essenziali",
                                    "Prof. Breglia")
            ),
            /*new Aula("Lab. di Microbiologia", 2, new LatLng(45.616727, 9.383946), // TODO
                    new Attivita
                            ("Tutti i segreti del microscopio",
                                    "Prof. Palermo")
            ),*/
            new Aula("Lab. Disegno 1", 3, new LatLng(45.616727, 9.383946),
                    new Attivita
                            ("Dall’idea all’oggetto",
                                    "Prof. Cocina - Prof. Cazzaniga - Prof. Previtali")
            ),
            new Aula(13, 4, new LatLng(45.616947, 9.383382),
                    new Attivita
                            ("Informazioni sul Liceo Sportivo",
                                    "Prof. Riva")
            ),
            new Aula("Lab. Sistemi 2", 1, new LatLng(45.615960, 9.383946),
                    new Attivita
                            ("Presentazione Ind. Elettronico: Robot… il tuo futuro",
                                    "Prof. Cerri - Prof. Pagano")
            ),
            new Aula("Lab. TDP", 1, new LatLng(45.616012, 9.383885),
                    new Attivita
                            ("Progettazione di apparecchiature elettroniche",
                                    "Prof. Nava")
            ),
            new Aula("Lab. Elettronica", 1, new LatLng(45.616012, 9.383885),
                    new Attivita
                            ("Alla scoperta delle apparecchiature elettroniche",
                                    "Prof. Racanati")
            ),
            new Aula("Lab. Sistemi 1", 0, new LatLng(45.615960, 9.383946),
                    new Attivita
                            ("Presentazione ind. Informatico: dall’hardware al software… un percorso innovativo!",
                                    "Prof. Iannì")
            ),
            new Aula(20, -1, new LatLng(45.617072, 9.383625),
                    new Attivita
                            ("Le certificazioni linguistiche… una finestra sul mondo!",
                                    "Prof. Fea")
            ),
            new Aula(39, -1, new LatLng(45.616428, 9.384592),
                    new Attivita
                            ("Alternanza Scuola Lavoro",
                                    "Prof. Russo")
            ),
            new Aula("Lab. Informatica", 0, new LatLng(45.616200, 9.384567),
                    new Attivita
                            ("Realizziamo un’App - Costruiamo un sito web",
                                    "Prof. Purgatorio - Prof. Campesan")
            ),
            new Aula("Lab. Cisco", 0, new LatLng(45.616597, 9.384398),
                    new Attivita
                            ("Incontriamo gli apparati Cisco",
                                    "Prof. Catalano - Prof. Gaglione")
            ),
            new Aula(27, -1, new LatLng(45.616832, 9.384237),
                    new Attivita
                            ("Presentazione della scuola con i video",
                                    "Alunni Scopazzo e Dinella 5D")
            ),
            new Aula("Polifunzionale", -1, new LatLng(45.616200, 9.384567),
                    new Attivita
                            ("Le nostre eccellenze",
                                    "Resp. Prof. Donatella Bonati")
            ),
            new Aula("Biologia", 2, new LatLng(45.617178, 9.383921),
                    new Attivita
                            ("La biologia intorno a noi",
                                    "Prof. Trifiletti")
            )
    };
}
