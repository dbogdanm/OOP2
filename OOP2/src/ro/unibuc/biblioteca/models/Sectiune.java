package ro.unibuc.biblioteca.models;

public class Sectiune
{
    private String idSectiune;
    private String denumire;

    public Sectiune(String idSectiune, String denumire)
    {
        this.idSectiune = idSectiune;
        this.denumire = denumire;
    }

    public String getIdSectiune() { return idSectiune; }
    public void setIdSectiune(String idSectiune) { this.idSectiune = idSectiune; }

    public String getDenumire() { return denumire; }
    public void setDenumire(String denumire) { this.denumire = denumire; }

    @Override
    public String toString() {
        return denumire;
    }
}