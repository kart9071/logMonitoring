import os
import subprocess
import requests

def run_batch_file():
    try:
        # Run the batch file
        subprocess.run('script.bat', shell=True, check=True)
    except Exception as e:
        print('Error running batch file:', e)

def send_message():
    try:
        # Define the URL
        url = 'http://localhost:8081/api/send-message'

        # Define the message
        message = 'Hello Kafka! this is karthik shetty how are you doing?'

        # Set request headers
        headers = {'Content-Type': 'text/plain'}

        # Send POST request with message
        response = requests.post(url, data=message)

        # Print response code
        print('Response Code:', response.text)

    except Exception as e:
        print('Error:', e)

if __name__ == '__main__':
    send_message()
