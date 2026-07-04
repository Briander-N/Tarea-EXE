use railway
CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    anio INT NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE,
    genero VARCHAR(50) NOT NULL
);

INSERT INTO libros (titulo, autor, anio, isbn, genero) VALUES
('Cien años de soledad', 'Gabriel García Márquez', 1967, '9780307474728', 'Novela'),
('1984', 'George Orwell', 1949, '9780451524935', 'Ciencia Ficción'),
('El Principito', 'Antoine de Saint-Exupéry', 1943, '9780156012195', 'Infantil');