# -*- coding: utf-8 -*-
"""
Created on Fri Jan 27 20:18:41 2023

@author: User
"""
import requests
import json
import pandas as pd

response = requests.get("https://tcgbusfs.blob.core.windows.net/dotapp/youbike/v2/youbike_immediate.json")
data = json.loads(response.text)
df = pd.DataFrame(list(data))
df.to_csv('youbike_stations.csv', index=False)
