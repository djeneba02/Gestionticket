/**DELIMITER $$

CREATE TRIGGER after_ticket_insert
    AFTER INSERT ON ticket FOR EACH ROW
BEGIN
    DECLARE message VARCHAR(255);

    -- Vérifier le statut du ticket et insérer des notifications appropriées
    CASE NEW.statut
        WHEN 'OUVERT' THEN
            SET message = CONCAT('Le ticket ', NEW.id, ' a été ouvert.');
        WHEN 'ENCOURS' THEN
            SET message = CONCAT('Le ticket ', NEW.id, ' est en cours de traitement.');
        WHEN 'TERMINE' THEN
            SET message = CONCAT('Le ticket ', NEW.id, ' a été terminé.');
        ELSE
            SET message = CONCAT('Le ticket ', NEW.id, ' a un statut non spécifié.');
        END CASE;

    INSERT INTO notification(ticket_id, message, date) VALUES (NEW.id, message, NOW());
END$$

DELIMITER ;**/





















/**
DELIMITER $$

CREATE TRIGGER after_ticket_update
    AFTER UPDATE ON ticket FOR EACH ROW
BEGIN
    DECLARE message VARCHAR(255);

    -- Vérifier le statut du ticket et insérer des notifications appropriées
    IF NEW.statut = 'OUVERT' THEN
        SET message = CONCAT('Le ticket ', NEW.id, ' a été ouvert.');
    ELSEIF NEW.statut = 'ENCOURS' THEN
        SET message = CONCAT('Le ticket ', NEW.id, ' est en cours de traitement.');
    ELSEIF NEW.statut = 'TERMINE' THEN
        SET message = CONCAT('Le ticket ', NEW.id, ' a été terminé.');
    ELSE
        SET message = CONCAT('Le ticket ', NEW.id, ' a un statut non spécifié.');
    END IF;

    INSERT INTO notification(ticket_id, message, date)
    VALUES (NEW.id, message, NOW());
END$$

DELIMITER ;**/
