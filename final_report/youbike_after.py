# -*- coding: utf-8 -*-
"""
Created on Thu Jan 26 23:50:44 2023

@author: User
"""
import requests
import json

# 取得youbike站點資訊
response = requests.get("https://tcgbusfs.blob.core.windows.net/dotapp/youbike/v2/youbike_immediate.json")
youbike_data = json.loads(response.text)

# 定義快速排序演算法
def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]['sbi']
    left = [x for x in arr if x['sbi'] < pivot]
    middle = [x for x in arr if x['sbi'] == pivot]
    right = [x for x in arr if x['sbi'] > pivot]
    return quick_sort(left) + middle + quick_sort(right)

# 將youbike站點資訊按照"sbi"進行排序
youbike_data = quick_sort(list(youbike_data))#['retVal'].values()

# 印出排序後的結果
for station in youbike_data:
    print(f'站點名稱: {station["sna"]}, 可借車輛數: {station["sbi"]}')


