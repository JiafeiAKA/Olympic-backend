until mysqladmin ping -h mysql --silent; do
    echo "Waiting for MySQL to be ready..."
    sleep 2
done
echo "MySQL is ready! Importing database..."
mysql -h mysql -u root -ppassword olympic < /olympic-init.sql
echo "Database imported successfully!"