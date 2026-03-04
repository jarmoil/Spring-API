# Spring-API - Dokumentaatio

## Yleiskatsaus

Spring-API on Spring Boot -pohjalla toteutettu REST API, joka hallinnoi asiakkaita, osoitteita, yhteystietoja ja tilauksia. API käyttää JPA/Hibernate-teknologiaa tietokantayhteyksille ja MariaDB-tietokantaa.

**Versio:** 3.5.11  
**Tietokanta:** MariaDB 11.7  
**Java:** 21  

---

## Perus URL
```
http://localhost:8080/api
```

---

# API-Päätepisteet

## Customers (Asiakkaat)

### 1. Hae asiakas ID:llä
```
GET /api/customers/{id}
```

**Kuvaus:** Hakee yhden asiakkaan ID:n perusteella.

**Vastaus (200 OK):**
```json
{
  "id": 1,
  "first_name": "John",
  "last_name": "Doe",
  "email": "john@example.com",
  "phone": "+358123456789"
}
```

**Esimerkki:**
```
GET /api/customers/1
```

---

### 2. Hae asiakkaita nimen alkuosalla
```
GET /api/customers/etunimi/{alku}
```

**Kuvaus:** Hakee asiakkaita joiden etunimi alkaa annetulla kirjaimilla. Käyttää LIKE-kyselyä `first_name`-sarakkeessa.

**Vastaus (200 OK):**
```json
[
  {
    "id": 1,
    "first_name": "John",
    "last_name": "Doe",
    "email": "john@example.com",
    "phone": "+358123456789"
  }
]
```

**Esimerkki:**
```
GET /api/customers/etunimi/Jo
```

---

### 3. Luo uusi asiakas
```
POST /api/customers
```

**Kuvaus:** Lisää uuden asiakkaan tietokantaan.

**Pyynnön body:**
```json
{
  "first_name": "John",
  "last_name": "Doe",
  "email": "john@example.com",
  "phone": "+358123456789"
}
```

**Vastaus (201 Created):** Luotu asiakas-objekti

---

### 4. Päivitä asiakas
```
PUT /api/customers/{id}
```

**Kuvaus:** Päivittää asiakkaan olemassa olevat tiedot.

**Pyynnön body:**
```json
{
  "first_name": "John",
  "last_name": "Smith",
  "email": "john.smith@example.com",
  "phone": "+358111111111"
}
```

**Vastaus (200 OK):** Päivitetty asiakas-objekti

---

### 5. Poista asiakas
```
DELETE /api/customers/{id}
```

**Kuvaus:** Poistaa asiakkaan ja kaikki häneen liittyvät tiedot.

**Vastaus (204 No Content):** Ei sisältöä

---

## Customer Addresses (Asiakkaan Osoitteet)

### 1. Hae osoite ID:llä
```
GET /api/customeraddresses/{id}
```

**Kuvaus:** Hakee yhden osoitteen ID:n perusteella.

**Vastaus (200 OK):**
```json
{
  "id": 1,
  "customer_id": 1,
  "street_address": "Mannerheimintie 123",
  "postal_code": "00100",
  "city": "Helsinki",
  "country": "Finland"
}
```

---

## Contacts (Yhteystiedot)

### 1. Hae kaikki yhteystiedot
```
GET /api/contacts
```

**Kuvaus:** Listaa kaikki järjestelmässä olevat yhteystiedot.

**Vastaus (200 OK):**
```json
[
  {
    "id": 1,
    "email": "contact@example.com",
    "reference": "ABC123DEF456789"
  }
]
```

---

### 2. Hae yhteystieto ID:llä
```
GET /api/contacts/{id}
```

**Kuvaus:** Hakee yhden yhteystiedon ID:n perusteella.

**Vastaus (200 OK):**
```json
{
  "id": 1,
  "email": "contact@example.com",
  "reference": "ABC123DEF456789"
}
```

---

### 3. Luo uusi yhteystieto
```
POST /api/contacts
```

**Kuvaus:** Lisää uuden yhteystiedon.

**Pyynnön body:**
```json
{
  "email": "contact@example.com",
  "reference": "ABC123DEF456789"
}
```

**Vastaus (201 Created):** Luotu yhteystieto-objekti

---

### 4. Päivitä yhteystieto
```
PUT /api/contacts/{id}
```

**Kuvaus:** Päivittää yhteystiedon tiedot.

**Pyynnön body:**
```json
{
  "email": "newemail@example.com",
  "reference": "XYZ987ABC654321"
}
```

**Vastaus (200 OK):** Päivitetty yhteystieto-objekti

---

### 5. Poista yhteystieto
```
DELETE /api/contacts/{id}
```

**Kuvaus:** Poistaa yhteystiedon.

**Vastaus (204 No Content):** Ei sisältöä

---

## Orders (Tilaukset)

### 1. Hae tilaus ID:llä
```
GET /api/orders/{id}
```

**Kuvaus:** Hakee yhden tilauksen ID:n perusteella.

**Vastaus (200 OK):**
```json
{
  "id": 1,
  "customer_id": 1,
  "order_date": "2026-03-04",
  "delivery_date": "2026-03-10",
  "shipping_address_id": 1,
  "status": "pending"
}
```

**Tilauksen kentät:**
- `id`: Tilauksen tunniste
- `customer_id`: Viittaus asiakkaaseen
- `order_date`: Tilauksen päivämäärä
- `delivery_date`: Toimituspäivämäärä
- `shipping_address_id`: Viittaus toimitusosoitteeseen
- `status`: Tilauksen tila (pending, shipped, delivered)

---

# Tietokantarakenne

## Customers-taulu

| Sarake | Tyyppi | Rajoitukset | Kuvaus |
|--------|--------|------------|--------|
| id | INT | PRIMARY KEY | Asiakkaan tunniste |
| first_name | VARCHAR(100) | | Etunimi |
| last_name | VARCHAR(100) | | Sukunimi |
| email | VARCHAR(255) | NOT NULL | Sähköpostiosoite |
| phone | VARCHAR(30) | | Puhelinnumero |

---

## Customeraddresses-taulu

| Sarake | Tyyppi | Rajoitukset | Kuvaus |
|--------|--------|------------|--------|
| id | INT | PRIMARY KEY | Osoitteen tunniste |
| customer_id | INT | FOREIGN KEY | Viittaus asiakkaaseen |
| street_address | VARCHAR(255) | | Katuosoite |
| postal_code | VARCHAR(10) | | Postinumero |
| city | VARCHAR(100) | | Kaupunki |
| country | VARCHAR(100) | | Maa |

---

## Contacts-taulu

| Sarake | Tyyppi | Rajoitukset | Kuvaus |
|--------|--------|------------|--------|
| id | INT | PRIMARY KEY | Yhteystiedon tunniste |
| email | VARCHAR(255) | NOT NULL | Sähköpostiosoite |
| reference | CHAR(32) | NOT NULL, UNIQUE | 32-merkkinen viitteentunniste |

---

## Orders-taulu

| Sarake | Tyyppi | Rajoitukset | Kuvaus |
|--------|--------|------------|--------|
| id | INT | PRIMARY KEY | Tilauksen tunniste |
| customer_id | INT | FOREIGN KEY | Viittaus asiakkaaseen |
| order_date | DATE | | Tilauksen päivämäärä |
| delivery_date | DATE | | Toimituspäivämäärä |
| shipping_address_id | INT | FOREIGN KEY | Viittaus toimitusosoitteeseen |
| status | VARCHAR(50) | | Tilauksen tila |

---

## OrderItems-taulu

| Sarake | Tyyppi | Rajoitukset | Kuvaus |
|--------|--------|------------|--------|
| order_id | INT | FOREIGN KEY, PRIMARY KEY | Viittaus tilaukseen |
| product_id | INT | PRIMARY KEY | Tuotteen tunniste |
| quantity | INT | | Määrä |
| unit_price | DECIMAL(10,2) | | Yksikköhinta |

---

# Kehittyneet Tietokantaominaisuudet

## Indeksit (Indexes)

### Automaattiset indeksit
✅ **PRIMARY KEY -indeksit**
- `customers(id)`
- `customeraddresses(id)`
- `contacts(id)`
- `orders(id)`
- `orderitems(order_id, product_id)` - Komposiitti-indeksi

✅ **FOREIGN KEY -indeksit** (automaattisesti luodut)
- `customeraddresses(customer_id)` → Customers(id)
- `orders(customer_id)` → Customers(id)
- `orders(shipping_address_id)` → Customeraddresses(id)
- `orderitems(order_id)` → Orders(id)

✅ **NOT NULL -sarakkeilla implisiittiset indeksit**
- `customers(email)` - sähköpostilla haku
- `contacts(email)` - sähköpostilla haku
- `contacts(reference)` - viittauksella haku


## Transaktioiden Hallinta

✅ **Spring Boot Transaction Management**
- JPA käyttää oletuksena automaattista transaktiohallintaa
- @Transactional -annotaatiot service-kerroksella (CustomerService)
- Hibernate hallinnoi transaktioiden alkua ja loppua

✅ **ACID-ominaisuudet**
- **Atomicity**: Kaikki operaatiot onnistuvat tai epäonnistuvat yhdessä
- **Consistency**: Tietokannan rajoitukset säilyvät
- **Isolation**: Transaktiot eivät häiritse toisiaan
- **Durability**: Tallennetut tiedot ovat pysyviä

---

## Referenssien Eheys (Referential Integrity)

✅ **Vierausavainrajoitukset pakottavat**
- Et voi luoda tilausta asiakkaalle, jota ei ole
- Et voi poistaa asiakasta, jolla on tilauksia
- Et voi käyttää osoitetta, jota ei ole

**Esimerkki:**
```sql
ALTER TABLE orders 
ADD CONSTRAINT fk_orders_customer 
FOREIGN KEY (customer_id) REFERENCES customers(id);
```

---

## Tietojen Validointi Tietokantatasolla

✅ **NOT NULL -rajoitukset**
- `customers.email` - sähköposti pakollinen
- `contacts.email` - sähköposti pakollinen
- `contacts.reference` - viittaus pakollinen

✅ **Pituusrajoitukset (VARCHAR)**
- first_name: max 100 merkkiä
- last_name: max 100 merkkiä
- email: max 255 merkkiä
- phone: max 30 merkkiä

✅ **Desimaalit (DECIMAL)**
- unit_price: 10 numeroa, 2 desimaalin tarkkuus

---

# Arkkitehtuuri ja Koodin Organisaatio

## Kerrosarkkitehtuuri

```
┌─────────────────────────────┐
│     REST API Layer          │ CustomersController, ContactsController jne.
│   @RestController           │
├─────────────────────────────┤
│   Service Layer             │ CustomerService
│   @Service                  │ Liiketoimintalogiikka, DTO muunnokset
├─────────────────────────────┤
│ Repository/DAO Layer        │ CustomersRepository extends JpaRepository
│ @Repository                 │ Tietokantakyselyt
├─────────────────────────────┤
│    JPA/Hibernate            │ ORM-kerros
├─────────────────────────────┤
│    Database Layer           │ MariaDB
│    (JDBC Connection)        │
└─────────────────────────────┘
```

## Entity-Relationship Diagram

```
┌──────────────┐
│  Customers   │
│              │
│ id (PK)      │──┐
│ first_name   │  │
│ last_name    │  │
│ email (NN)   │  │
│ phone        │  │
└──────────────┘  │
     │            │
     │ 1:N        │
     │            ├──────────────────┐
     │            │                  │
     ▼            │                  ▼
┌──────────────┐  │          ┌──────────────┐
│Orders        │  │          │Customeraddres│
│              │  │          │             │
│ id (PK)      │  │          │ id (PK)     │
│ customer_id  │──┘          │customer_id  │──┐
│ order_date   │             │street_addr  │  │
│ delivery_date│             │postal_code  │  │
│ship_addr_id  │─────────────┤city         │  │
│ status       │             │country      │  │
└──────────────┘             └──────────────┘  │
     │                                         │
     │ 1:N                                     │
     ▼                                         │
┌──────────────┐                               │
│OrderItems    │                               │
│              │                               │
│ order_id(PK) │                               │
│ product_id(PK)                               │
│ quantity     │                               │
│ unit_price   │                               │
└──────────────┘                               │
                                               │
                           ┌──────────────┐    │
                           │  Contacts    │    │
                           │              │    │
                           │ id (PK)      │    │
                           │ email (NN)   │    │
                           │reference(UQ) │    │
                           └──────────────┘    │
                                               │
                                    (ei suoraa)
```

---

# Yhteenveto Toteutetuista Ominaisuuksista

## ✅ Toteutetut
1. **REST API** - Täydellinen CRUD
2. **JPA/Hibernate** - 5 entiteettiä
3. **Custom kyselyt** - findByEtunimiAlkaa()
4. **DTO-mallit** - Tietojen kapsulointiin
5. **Service-kerros** - Liiketoimintalogiikka
6. **Vierausavaimet** - Referenssien eheys
7. **Indeksit** - Pääavaimet ja FK-indeksit
8. **Transaktiot** - JPA hallinnoi
9. **Validointi** - NOT NULL, UNIQUE
10. **MariaDB** - Relaatiotietokanta


**Dokumentaation päivittyneisyys:** 4.3.2026  
**Tekijä:** Jarmo I.
